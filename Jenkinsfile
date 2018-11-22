pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                checkout scm
                sh './gradlew -version'
                sh './gradlew build -x test'
            }
        }
        stage('UnitTests') {
            steps {
                sh './gradlew test'
                junit 'build/test-results/test/*.xml'
            }
        }
    }
}
