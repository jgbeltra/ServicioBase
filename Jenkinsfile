pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('Checkout external proj') {
            steps {
                git branch: 'feature/jennifers-feature',
                    credentialsId: 'jgbeltra',
                    url: 'https://github.com/jgbeltra/ServicioBase.git'
            }
        }
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
