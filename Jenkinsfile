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
      when {
        expression {
          BRANCH_NAME == 'main'
        }
      }
      steps{
        script{
          echo "deploy the app here"
        }
      }
    }
  }
}