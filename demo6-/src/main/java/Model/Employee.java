package Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employee {
    @NotNull
    @Size(min=2,message = "The Id should be Upper 2")
    private String ID;
    @NotNull(message = "id should not be empty")
    @Size(min=4,message = "The Id should be Upper 2")
    private String name;
    @NotNull(message = "id should not be empty")
    @Min(value=25, message = "The age should be above 25")
    private int age ;
    @NotNull(message = "id should not be empty")
  @Pattern(regexp = "supervisor|Coordinate",message = "Postion Should be Supervisor OR Coordinate")
    private String postion;
    @AssertFalse
  private boolean onLeave;//هو باجازه ولا لا
    @NotNull(message = "id should not be empty")
    @PastOrPresent(message = "Should enter less then current year")
//    @PositiveOrZero
    private Date employmentYear;
    @NotNull(message = "id should not be empty")
    @Positive
    private int annualLeave;
}
