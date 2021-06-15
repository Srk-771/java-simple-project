import hudson.plugins.git.*;

def scm = new GitSCM("https://github.com/Srk-771/java-simple-project.git")
scm.branches = [new BranchSpec("master")];

def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition(scm, "Jenkinsfile")

def parent = Jenkins.instance
def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(parent, "java-app")
def description = "helloworld project"
def poll = '* * * * *'
job.definition = flowDefinition

parent.reload()
