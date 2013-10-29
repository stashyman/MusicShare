MusicShare
==========

From now on, whenever you edit any of the files, write here what you changed so we know what still needs to be done.

I got adding playlists working, and I had to update a couple of the files. You should be able to play playlist also, although the menu doesn't reflect this yet.


Problems to be addressed
=====================

1: Need to add the borrowed songs attibutes (time, plays). 

2: playlist (add songs from owned library to playlists, also check if borrowed and don't allow to play if so)

3: library sorting setting (changing profile setting) (Ben is in the process of geting this to work)

4: We need to move the functionality of borrowing a song from option 5 (send message) to option 3 (borrow a song)

5.: library sorting (actually sorting the songs) (Ben is in the process of geting this to work)

7: song visability (profile option to allow songs to be friends only or public browsing)

8: being able to change the borrow length, and be either time in minutes or num plays (in profile seetings)



Issues recently fixed
=====================

1: users' friends lists are now synced, if one user has another user as a friend, but not vice versa,
they will both be added to each other's friends list.

2: Users were showing up on the logged in list more than once.

3: added check in User.java for empty friends list

4. Fixed a few user input errors. 

5. Taking back a song works now. Check if user is logged in and on friends list, and then check if the owner of the song matches the current user. When song is taken back, remove the song from both user's playable library and add it to the owners library.

6. Library searching now works for friends (nonfriends) and public.
