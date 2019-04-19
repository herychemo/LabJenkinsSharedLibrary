// vars/getContainerIp.groovy

def call(String containerIdentifier) {
    def containerIP = sh script: """
        docker inspect ${containerIdentifier} | grep '"IPAddress"' | awk 'NR==1{print \$2}' | sed 's/"//g;s/,//g'
    """, returnStdout: true
    return containerIP?.trim()
}
