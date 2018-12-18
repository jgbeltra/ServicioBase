@Library("devops-shared-functions") _

pipeline {
    agent any

stages {
    stage('Build') {
        steps {
            checkout scm
            sh './gradlew -version'
            sh './gradlew clean'
            sh './gradlew build -x test'
        }
    }

   stage('BDScriptsExecution'){
	  steps{
		sh"ls"sh"pwd"script{
		  bdExecute"/bd/scripts"
		}
	  }
	}
    
   }
}
