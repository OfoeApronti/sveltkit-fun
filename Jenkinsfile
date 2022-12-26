def gv
pipeline {
  agent any
  tools {
    nodejs "node"
  }
  // environment {
  //   IMAGE_NAME = 'blowman/my-app:1.3'
  // }
  stages {
    stage("init"){
      steps {
        script {
          gv = load "script.groovy"
          //echo "Initializing"
        }
      }
    }
    stage("setversion"){
      steps {
        script {
          gv.updateVersion()
        }
      }
    }
    stage("build"){
      steps {
        script {

        sh "npm config ls"
        }
      }
    }
    stage("build image"){
      steps {
        // //local deployment to nexus
        // script{
        //   echo 'building the docker image for local nexus'
        //   withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable:'PWD',
        //   usernameVariable: 'USER')]){
        //     sh "docker build -t localhost:8083/${IMAGE_NAME} ."
        //     sh "echo $PWD | docker login -u $USER --password-stdin localhost:8083"
        //     sh "docker push localhost:8083/${IMAGE_NAME}"
        //   } 

        //deployment to docker hub
          script{
          echo 'building the docker image for dockerhub.com'
          withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable:'PWD',
          usernameVariable: 'USER')]){
            sh "docker build -t ${env.IMAGE_NAME} ."
            sh "echo $PWD | docker login -u $USER --password-stdin"
            sh "docker push ${env.IMAGE_NAME}"
          } */
          
        }
      }
    }
    stage("deploy"){
      steps{
        // script{
        //   echo "deploy the app here using docker run"
        //   //using the docker approach
        //   def dockerCmd = 'docker run -p 3080:3000 blowman/my-app:1.3'
        //   sshagent(['ec2-server-key']) {
        //       sh "ssh -o StrictHostKeyChecking=no ec2-user@${EC2DOCKERSERVER} ${dockerCmd}"
        //   }
        // }
        //
        // script{
        //   echo "deploy the app here using docker compose"
        //   //docker compose approach
        //   def dockerComposeCmd = "docker compose -f /home/ec2-user/docker-compose.yaml up -d"
        //   sshagent(['ec2-server-key']) {
        //       sh "scp docker-compose.yaml ec2-user@${EC2DOCKERSERVER}:/home/ec2-user"
        //       sh "ssh -o StrictHostKeyChecking=no ec2-user@${EC2DOCKERSERVER} ${dockerComposeCmd}"
        //   }
        // }
        //
        script{
          echo "IMAGE_NAME ${IMAGE_NAME}"
          echo "deploy the app here using shell/bash script ${env.IMAGE_NAME}"
          //bash script approach
          def bashCmd = "bash ./server-shell-cmds.sh ${env.IMAGE_NAME}"
          sshagent(['ec2-server-key']) {
              sh "scp server-shell-cmds.sh ec2-user@${EC2DOCKERSERVER}:/home/ec2-user"
              sh "ssh -o StrictHostKeyChecking=no ec2-user@${EC2DOCKERSERVER} ${bashCmd}"
          }
        }
      }
    }
    stage("post deployment"){
      steps{
        script{
          sshagent(['bd3acd4b-51cf-4cd9-928e-9ed069bd0e92']) {
                // some block
                sh "git remote set-url origin git@gitlab.com:goapronti/nvim-setup.git"
                sh "git add ."
                sh 'git commit -m "ci: version bump"'
                sh 'git push origin main'
            }

        }
      }
    }
  }
}