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
          def dockerCmd = 'docker run -p 3080:3000 blowman/my-app:1.3'
          sshagent(['ec2-server-key']) {
              sh "ssh -o StrictHostKeyChecking=no ec2-user@${EC2DOCKERSERVER} ${dockerCmd}"
          }
        }
      }
    }
  }
}