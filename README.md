Things to do
============

We need to change edit metadata to also change the song that's in playable, if it's in playable. Also shouldn't be able to change metadata for lent song.

We need to add all remaining assumtions to the assumtions.txt file

Implememnt Jon's fixes that I overwrote






Errors that have been found so far
==================================
first number equals the main menu option and #) is the sub menu option

(3) (2) When taking back a song and invalid input is given it dumps out to menu and does not allow for another song choice/



if need to contact me (Jon) just text or contact me on skype


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

14. Setting a queue for a borrowed song. (decided to not make a queue and just not allow the borrow if already being lent

15. Borrowing and sending back songs working properly

