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
                    stash includes: "build/libs/*.jar", name: 'artifact'

            }
        }

        stage('ArtifactoryPublish') {
        	steps {
        		sh "pwd"
        		unstash 'artifact'
        	    script {
        	        def server = Artifactory.server 'JennifersArtifactory'
        	        def uploadSpec = """{
        	        "files": [{
        	             "pattern": "build/libs/${pipelineParams.jarName}.jar",
        	             "target": "servicio-base/beta/"
        	              }]
        	              }"""
        	         server.upload(uploadSpec)
        	       }
        	 }
        }

    }
}
