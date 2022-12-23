pipeline {
  agent any
  tools {
    nodejs "node"
  }
  stages {
    stage("build"){
      steps {
        script {

        sh "npm config ls"
        }
      }
    }
    stage("build image"){
      steps {
        script{
          echo 'building the docker image'
          /* withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable:'PWD',
          usernameVariable: 'USER')]){
            sh "docker build -t localhost:8083/my-app:1.3 ."
            sh "echo $PWD | docker login -u $USER --password-stdin localhost:8083"
            sh "docker push localhost:8083/my-app:1.3"
          } */
          
        }
      }
    }
    stage("deploy"){
      steps{
        script{
          echo "deploy the app here"
          //using the docker approah
          //def dockerCmd = 'docker run -p 3080:3000 blowman/my-app:1.3'
          //

          //docker compose approah
          def dockerComposeCmd = "docker compose -f /home/ec2-user/docker-compose.yaml up -d"
          sshagent(['ec2-server-key']) {
              sh "scp docker-compose.yaml ec2-user@${EC2DOCKERSERVER}:/home/ec2-user"
              //sh "ssh -o StrictHostKeyChecking=no ec2-user@${EC2DOCKERSERVER} ${dockerCmd}"
              sh "ssh -o StrictHostKeyChecking=no ec2-user@${EC2DOCKERSERVER} ${dockerComposeCmd}"
          }
        }
      }
    }
  }
}