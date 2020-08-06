import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(length = 20, nullable = false, unique = true)
    private String account;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String role;

    @Column(length = 20, nullable = false) // unique?
    private String name;

    @Column(length = 11, nullable = false, unique = true)
    private String phonenumber;

    @Column(length = 50, nullable = false)
    private String address;
}