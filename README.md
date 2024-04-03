# BE-Common
    Prerequisites:
        - The following items should be installed in your system:
            . Java 18
            . Git command line tool (https://help.github.com/articles/set-up-git)
            . IDE 
                + Eclipse
                + Spring Tools Suite (STS)
                    . Install STS (Help -> Eclipse marketplace -> search spring tool 4 -> Go -> Install)
    Steps:
        1. On the command line
            - Git clone url project
        2. Inside Eclipse
            - File -> Import -> Maven -> Existing maven project -> Select of your project
        Then using the Eclipse launcher (right click on project and Run As -> Maven install) to generate, then (right click on project and Maven -> Update project). Run the application main method by right clicking on it and choosing Run As -> Spring Boot App
        3. Try it out 
            - The entry point address of the backend API is at http://localhost:8085/api/user/users.