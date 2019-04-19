// vars/getContainerIp.groovy

def call(String containerId) {
    def containerIP = sh script: """
        docker inspect ${containerId} | grep '"IPAddress"' | awk 'NR==1{print \$2}' | sed 's/"//g;s/,//g'
    """
    return containerIP
}
