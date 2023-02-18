pipeline {
 agent any
 
 options {
  skipDefaultCheckout()
 }
 stages {
  stage('SCM') {
   steps {
    checkout scm
   }
  }
  stage('Build') {
   stages {
    stage('Compile') {
     agent {
      docker {
       image 'maven:3.6.0-jdk-8-alpine'
       args '-v /root/.m2/repository:/root/.m2/repository'
       reuseNode true
      }
     }
     steps {
      sh ' mvn install'//pour obtenir le jar
     }
    }
  stage('Code Quality Analysis') {
   stages {
    stage('PMD') {
     agent {
      docker {
       image 'maven:3.6.0-jdk-8-alpine'
       args '-v /root/.m2/repository:/root/.m2/repository'
       reuseNode true
      }
     }
     steps {
      sh ' mvn pmd:pmd'
      // using pmd plugin
      step([$class: 'PmdPublisher', pattern: '**/target/pmd.xml'])
     }
    }
    stage('Findbugs') {
     agent {
      docker {
       image 'maven:3.6.0-jdk-8-alpine'
       args '-v /root/.m2/repository:/root/.m2/repository'
       reuseNode true
      }
     }
     steps {
      sh ' mvn findbugs:findbugs'
      // using findbugs plugin
      findbugs pattern: '**/target/findbugsXml.xml'
     }
    }
    // stage('JavaDoc') {
    //  docker  {
    //   any{
    //    image 'maven:3.6.0-jdk-8-alpine'
    //    args '-v /root/.m2/repository:/root/.m2/repository'
    //    reuseNode true
    //   }
    //  }
    //  steps {
    //   sh ' mvn javadoc:javadoc'
    //   step([$class: 'JavadocArchiver', javadocDir: './target/site/apidocs', keepAll: 'true'])
    //  }
    // }
    //sonarQube
   }
   post {
    always {
     // using warning next gen plugin
     recordIssues aggregatingResults: true, tools: [javaDoc(), checkStyle(pattern: '**/target/checkstyle-result.xml'), findBugs(pattern: '**/target/findbugsXml.xml', useRankAsPriority: true), pmdParser(pattern: '**/target/pmd.xml')]
    }
   }
  }
   }
  }
  stage('Unit Tests') {
   when {
    anyOf { branch 'main'; branch 'delivery' }
   }
   agent {
    docker {
     image 'maven:3.6.0-jdk-8-alpine'
     args '-v /root/.m2/repository:/root/.m2/repository'
     reuseNode true
    }
   }
   steps {
    sh 'mvn test'
   }
   post {
    always {
     junit 'target/surefire-reports/**/*.xml'
    }
   }
  }
  stage('Integration Tests') {
   when {
    anyOf { branch 'main'; branch 'delivery' }
   }
   agent {
    docker {
     image 'maven:3.6.0-jdk-8-alpine'
     args '-v /root/.m2/repository:/root/.m2/repository'
     reuseNode true
    }
   }
   steps {
    sh 'mvn verify -Dsurefire.skip=true'
   }
   post {
    always {
     junit 'target/failsafe-reports/**/*.xml'
    }
    success {
     stash(name: 'artifact', includes: 'target/*.jar')
     stash(name: 'pom', includes: 'pom.xml')
     // to add artifacts in jenkins pipeline tab (UI)
     archiveArtifacts 'target/*.jar'
    }
   }
  }
  stage('Build docker Image'){
            steps{
                dir("Containers/opengeo-app") {
                    sh "docker build -t opengeo-app:1.0.0 ."
                }
            }
        }
  stage('Testing image') {
            steps
            {
                script {
                    containerName = sh(returnStdout: true, script: "docker ps -a -f 'name=container-test' --format '{{.Names}}'").trim()
                    if(containerName == "container-test")
                    {
                        sh 'docker rm container-test --force'
                        sh "echo 'Nettoyage environnement OK'"
                    }
                    else
                    {
                        sh "echo 'Environnement OK'"
                    }
                }
            }
        }

stage('Run Docker Container') {
            steps {
                sh 'docker run -d -p 8090:8080 --name test-container opengeo:latest'
                sh 'sleep 15s'
            }
        }
        stage('Test Docker Container') {
            steps {
               sh 'curl http://localhost:8090'
            }
        }

        stage('Clean Environment') {
            steps {
                sh 'docker stop test-container'
                sh 'docker rm test-container'
            }
        }
//deploy to kubernates

 } //end stages
} //end pipeline