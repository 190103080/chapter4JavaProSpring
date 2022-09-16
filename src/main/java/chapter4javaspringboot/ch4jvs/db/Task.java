package chapter4javaspringboot.ch4jvs.db;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private Long id;
    private String name;
    private String deadlineDate;
    private String description;
    private boolean isCompleted;

}
