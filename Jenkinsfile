pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t consultorio-medico-jammy .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run --rm consultorio-medico-jammy java -version'
            }
        }
    }

   post {
    success {
        mail to: 'jose.malavebri@gmail.com',
             subject: "Pipeline SUCCESS | ${env.JOB_NAME} #${env.BUILD_NUMBER}",
             body: """
✔ *Estado:* SUCCESS
✔ *Proyecto:* ${env.JOB_NAME}
✔ *Build:* #${env.BUILD_NUMBER}
✔ *URL del Build:* ${env.BUILD_URL}
✔ *Duración:* ${currentBuild.durationString.replace(' and counting', '')}
✔ *Commit:* ${env.GIT_COMMIT}
✔ *Rama:* ${env.GIT_BRANCH}

El pipeline terminó correctamente.
"""
    }

    failure {
        mail to: 'jose.malavebri@gmail.com',
             subject: "Pipeline FAILURE | ${env.JOB_NAME} #${env.BUILD_NUMBER}",
             body: """
✖ *Estado:* FAILURE
✖ *Proyecto:* ${env.JOB_NAME}
✖ *Build:* #${env.BUILD_NUMBER}
✖ *URL del Build:* ${env.BUILD_URL}
✖ *Duración:* ${currentBuild.durationString.replace(' and counting', '')}
✖ *Commit:* ${env.GIT_COMMIT}
✖ *Rama:* ${env.GIT_BRANCH}

El pipeline falló. Revisa la consola para más detalles.
"""
    }
}

}
