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
        stage('UnitTests') {
            steps {
                sh './gradlew test'
                junit 'build/test-results/test/*.xml'

                publishHTML (target: [
                      allowMissing: false,
                      alwaysLinkToLastBuild: false,
                      keepAll: true,
                      reportDir: 'build/reports/tests/test',
                      reportFiles: 'index.html',
                      reportName: "Unit Tests Report"
                    ])

            }
        }
    }
}
