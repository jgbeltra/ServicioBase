pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stage('Checkout external proj') {
        steps {
            git branch: 'feature/jennifers-feature',
                credentialsId: 'jgbeltra',
                url: 'https://github.com/jgbeltra/ServicioBase.git'
        }
    }
    stages {
           stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
