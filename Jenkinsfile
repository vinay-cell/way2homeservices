pipeline {
    agent any
    tools {
        maven "maven"
    }
    stages {
        stage("fetch code from github") {
            steps {
                git "https://github.com/vinay-cell/way2homeservices.git"
            }
        }
        stage("build artifact") {
            steps {
                sh "mvn clean install"
            }
        } 
    }
}
