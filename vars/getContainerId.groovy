// vars/getContainerId.groovy

def call(String containerName) {
    def containerId = sh script: """
        docker ps | grep ${containerName} | awk '{print \$1}'
    """, returnStdout: true
    return containerId?.trim()
}
