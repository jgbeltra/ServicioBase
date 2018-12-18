@Library("devops-shared-functions")_

pipeline{
  agent any
  stages{
    stage('Build'){
      steps{
        checkoutscmsh'./gradlew -version'sh'./gradlew clean'sh'./gradlew build -x test'
      }
    }
	stage('BDScriptsExecution'){
      steps{
        sh"ls"script{
          bdExecute "/bd/scripts"
        }
      }
    }
  }
}
