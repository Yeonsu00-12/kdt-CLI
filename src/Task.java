public class Task {
    String taskName;
    int experienceGained;
    int energyCost;

    Task(String taskName, int experienceGained, int energyCost) {
        this.taskName = taskName;
        this.experienceGained = experienceGained;
        this.energyCost = energyCost;
    }

    void completeTask(JobCharacter job) {
        if (job.energy >= energyCost) {
            job.energy -= energyCost;
            job.gainExperience(experienceGained);
            System.out.println(taskName + " 작업을 완료했습니다. 에너지가 " + energyCost + "만큼 감소했습니다.");
        } else {
            System.out.println("에너지가 부족합니다. 에너지를 충전해야 합니다.");
        }
    }
}
