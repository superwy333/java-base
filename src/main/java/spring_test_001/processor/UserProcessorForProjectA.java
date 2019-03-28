package spring_test_001.processor;

public class UserProcessorForProjectA implements Processor {

    private String projectId;

    public UserProcessorForProjectA(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String getProjectId() {
        return projectId;
    }

    @Override
    public boolean userLogin() {
        System.out.println("执行ProjectA的userLogin方法");
        return false;
    }
}
