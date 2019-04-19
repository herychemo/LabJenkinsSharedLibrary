// vars/isServiceRunningOn.groovy

def call(String service, String host, String user='', String sshCredentials = '') {
    def cmd = "ps aux | grep ${service} | awk '{print \\\$2}'"
    def PID = sshCmd(cmd, host, user, sshCredentials)
    return PID != ""
}
