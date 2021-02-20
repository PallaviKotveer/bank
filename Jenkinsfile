pipeline {
agent any
stages {
   stage('Code Quality Check via SonarQube') {
   steps {
       script {
       def scannerHome = tool 'sonar-scanner';
           withSonarQubeEnv("SonarQube") {
           sh "${tool("sonar-scanner")}/bin/sonar-scanner -Dsonar.projectKey=bankApp -Dsonar.projectName=BankAppdemo -Dsonar.projectVersion=1.0 -Dsonar.sources=/var/lib/jenkins/workspace/sample/src/com/bankapp/pkg -Dsonar.language=java -Dsonar.java.binaries=build/classes"
               }
           }
       }
   }
}
}
