package spring_test_001.processor;

public class UserProcessorForProjectB implements Processor {

    private String projectId;

    public UserProcessorForProjectB(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public String getProjectId() {
        return projectId;
    }

    @Override
    public boolean userLogin() {
        System.out.println("执行ProjectB的userLogin方法");
        return false;
    }
}
