//CODE SMELL: class UserService đang làm quá nhiều việc -> vi phạm nguyên tắc Single Responsibility
//REFACTOR CODE B: extract class: tách ra từng lớp chuyên biệt
public class CODEB {
//    class UserService {
//        public User findById(int id) {}
//    }
//
//    class EmailService {
//        public void sendWelcomeEmail(User user) {}
//        public void sendPasswordResetEmail(User user) {}
//    }
//
//    class UserView {
//        public void renderUserProfile(User user) {}
//    }
//
//    class UserExportService {
//        public String exportUserToCvs(User user) {}
//    }
}