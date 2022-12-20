pipeline {
  agent none
  stages {
    stage('test'){
      steps {
        script{
          echo "Testing the application"
          echo "Executing pipeline for $BRANCH_NAME"
        }
      }
    }
    stage("build"){
      when {
        expression {
          BRANCH_NAME == 'main'
        }
      }
      steps {
        script {

        sh "npm config ls"
        }
      }
    }
    stage("deploy"){
      /* when {
        expression {
          BRANCH_NAME == 'main'
        }
      } */
      steps{
        script{
          def dockerCmd = 'docker run -p 3080:3000 blowman/my-app:1.3'
          sshagent(['ec2-server-key']) {
              sh "ssh -o StrictHostKeyChecking=no ec2-user@54.146.147.10 ${dockerCmd}"
          }
        }
      }
    }
  }
}