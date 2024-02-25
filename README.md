# Практическая задача 3.1.4 Java pre-project. Задача 3.2. Работа с Bootstrap.
CRUD приложение с использованием Spring Boot, Spring Security, Hibernate, Bootstrap
##
- config
    - [PasswordEncoderConfig](src/main/java/com/example/springsecuritybootstrap/config/PasswordEncoderConfig.java)
    - [SecurityConfig](src/main/java/com/example/springsecuritybootstrap/config/SecurityConfig.java)
    - [SuccessUserHandler](src/main/java/com/example/springsecuritybootstrap/config/SuccessUserHandler.java)
- controller
  - [AdminController](src/main/java/com/example/springsecuritybootstrap/contoller/AdminController.java)
  - [UserController](src/main/java/com/example/springsecuritybootstrap/contoller/UserController.java)
- entity
  - [Role](src/main/java/com/example/springsecuritybootstrap/entity/Role.java)
  - [User](src/main/java/com/example/springsecuritybootstrap/entity/User.java)
- repository
  - impl
    - [RoleRepositoryImpl](src/main/java/com/example/springsecuritybootstrap/repository/impl/RoleRepositoryImpl.java)
    - [UserRepositoryImpl](src/main/java/com/example/springsecuritybootstrap/repository/impl/UserRepositoryImpl.java)
  - [RoleRepository](src/main/java/com/example/springsecuritybootstrap/repository/RoleRepository.java)
  - [UserRepository](src/main/java/com/example/springsecuritybootstrap/repository/UserRepository.java)
- service
  - impl
    - [RoleServiceImpl](src/main/java/com/example/springsecuritybootstrap/service/impl/RoleServiceImpl.java)
    - [UserServiceImpl](src/main/java/com/example/springsecuritybootstrap/service/impl/UserServiceImpl.java)
  - [RoleService](src/main/java/com/example/springsecuritybootstrap/service/RoleService.java)
  - [UserService](src/main/java/com/example/springsecuritybootstrap/service/UserService.java)
- [SpringSecurityBootstrapApplication](src/main/java/com/example/springsecuritybootstrap/SpringSecurityBootstrapApplication.java)


Тестовые логин и пароль:
admin@gmail.com : admin
user@gmail.com : user
    