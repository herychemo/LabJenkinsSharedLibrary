// vars/isContainerRunning.groovy

def call(String containerIdentifier) {
    def CONTAINER_ID = getContainerId(containerIdentifier)
    return CONTAINER_ID?.trim() != ""
}
