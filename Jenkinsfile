pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('Build') {
            steps {
                checkout scm
                sh './gradlew -version'
                sh './gradlew clean'
                sh './gradlew build -x test'
            }
        }
        stage('UnitTests') {
            steps {
                sh './gradlew test'
                junit 'build/test-results/test/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                sh './gradlew bootRun'
            }
        }
    }
}
