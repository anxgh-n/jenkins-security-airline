pipeline {
    agent any

    tools{
        maven 'my-maven'
        jdk 'my-jdk'
    }

    stages {
        stage('Git') {
            steps {
                echo 'Pull code from github'
                git url : 'https://github.com/anxgh-n/jenkins-security-airline.git',branch:'master'
            }
        }
        stage('Build') {
            steps {
                echo 'Build project using maven'
                bat "mvn clean install -DskipTests"
            }
        }
        stage('Test') {
            steps {
                echo 'Test your application'
                bat "mvn test"
            }
        }
        stage('Deploy'){
            steps{
                echo 'Deploy the project'
                bat 'docker build -t auth-image .'
                bat 'docker run -p 8090:8090 -d --name auth-container auth-image'
            }
        }
    }
}
