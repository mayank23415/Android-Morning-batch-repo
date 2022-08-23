***Git &  GitHub***

***Git***
- Git is a ```Distributed Version Control System```
- Visit this [website](https://git-scm.com/) and download git software on your computer
- Git is also a ```Source Code Management System```
- Git is developed by ```Linus Torvalds```, the man behind the developmemt of Linux Kernel.
- Git was released in the year 2005.

***Types of Version Control Systems***

- Centralised Version Control System (CVCS)
    - Subversion
- Distributed Version Control System (DVCS)
    - Git, Mericurial

***[Dont Miss Out on this Free Ebook](https://git-scm.com/book/en/v2)***

***Few Terminologies to Understand***
- **Repository:** A repository is a place where your project is present/hosted.
- **Commit:** It literally means to save the version of your software.
- **Working Directory:** It is the folder in which your project files are located typically in the local system. 

***Commands***
***Let Git Understand who you are and your email id***
```git
git config --global user.email "pavankreddy.t@gmail.com"
```

Check The user email
```git
git config user.email
```
```git
git config --global user.name "pavan"
```
```git
git config user.name
```

***Create a Git Repository (initialize)***
- This init command has to be  used only once in the entire lifecycle of the repository. You dont need to reinitalize git repository
- With git init command you will create an invisible folder in your ```Working Directory``` (project folder).
- git init
    - As soon as this command is run, we get ```.git``` folder in the working directory.
    - This folder will save all your versions and also manage the data for source code management.
    - ```git init```
- git add <fileName>
    - This command would copy the files that you want to save to the Staging area
    - ```Staging Area``` is the place where all the about to be committed files will be located.
    - Without putting files to staging area, you cannot make a commit on the repositiory.
    - ```git add AboutUs.html```
    - ```git add .```
- git status
    - This command would let you know the status of all the files in your project. 
    - This will also let you know if there any changes happend to the files that needs to be saved.
    - ```git status```
- git rm
    - This command would help you take out a file from staging area
    - ```git rm --cached AboutUs.html```
- git commit
    - This command will create a snapshot in the repository with the files that are presently in the Staging area
- git log
    - This command shows the history of the commits till the recent in chronological order.
    - ```git log```
    - ```git log --oneline``` - Displays all the commits in oneline each.
    - ```git log --reverse``` - displays all the commits in reverse order (first commit on top)
- git checkout
    - This command would essentially take you to the commit that you are interested.
    - ```git checkout <Commit SHA Key>```
    
***Working with Remotes***
    
 - Create a remote repository 
- [github](https://github.com)
- [bitbucket](https://bitbucket.org)
- [gitlab](https://gitlab.com)

- Create a repository without any initial commits. (Dont create README.MD)
- Check for any remotes available on the local system
- ```git remote```
- Now, add your remote to the local system
- ```git remote add <Var Name> https://github.com/tadipavankumarreddy/Experiment1.git```
- to push all the changes to the remote system
- ```git push <var_name> master```
    
 









