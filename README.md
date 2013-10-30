ADDING CODE TO THE UI
=====================
PLEASE ADD THE CODE TO THE UI2.java, because that is the one that I have done a lot of cleanup to and am testing.

I don't see the point of UI2. I took the updated code in UI2 and added upon it, then put it in UI. The borrowed song atributes are added
and I have the default settings working also, but we never send a song back after it has been done yet.
PLEASE REMEMBER TO DOWNLOAD THE MOST RECENT CODE WHEN YOU WANT TO WORK. I'm looking at you Brendan. --Rory

Errors that have been found so far
==================================
first number equals the main menu option and #) is the sub menu option

(2) (1) Add a song gives an out of bounds error when adding the song with any combination

(3) (1) When requesting a song from self it displays that you can not request from self but then still shows songs and asks what song you wish to borrow.
	    Did not want - Fixed
   
(3) (2) When taking back a song from a friend and they are not logged in, it still shows friends songs.
	    Did not want - Fixed
  
(3) (2) When taking back a song and invalid input is given it dumps out to menu and does not allow for another song choice/

(4) (2) When input invalid information then it kicks back to menu and does not ask until get either a yes or no.

(6) (3) When selecting search all non friends it does not show me my non friends songs == fixed Rory==


if need to contact me (Jon) just text or contact me on skype


Problems to be addressed
=====================

1: Need to implement the borrowed songs attibutes (time, plays). 


7. Setting a queue for a borrowed song.



Issues recently fixed
=====================

1: users' friends lists are now synced, if one user has another user as a friend, but not vice versa,
they will both be added to each other's friends list.

2: Users were showing up on the logged in list more than once.

3: added check in User.java for empty friends list

4. Fixed a few user input errors. 

5. Taking back a song works now. Check if user is logged in and on friends list, and then check if the owner of the song matches the current user. When song is taken back, remove the song from both user's playable library and add it to the owners library.

6. Library searching now works for friends (nonfriends) and public.

7. Functionaliry for setting 5 has been moved to 3.

8. Finished Library visibility. Users now have option to set whether or not the public can view their library.

9. Added Logout function.

10. playlist 
 
11. being able to change the borrow length, and be either time in minutes or num plays (in profile seetings)

12. library sorting setting (changing profile setting)

13. library sorting (actually sorting the songs)
