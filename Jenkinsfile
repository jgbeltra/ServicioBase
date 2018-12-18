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
    
    stage('BDScriptsExecution') {
        steps {
            script {
                bdExecute("//bd//scripts", "//bd//config.json")
            }
        }
     }
    
   }
}
