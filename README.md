MusicShare
==========

From now on, whenever you edit any of the files, write here what you changed so we know what still needs to be done.


Problems to be addressed
=====================

1: Need to add the borrowed songs attibutes (time, plays). I just added accepting/denying requests. Accepting a request removes a song from a user's playable library and adds it to the requester's playable library. Working on taking back a song next. Rory - Do you remember what Phillipa said about taking back a song? Can we take back a song from someone that we borrowed it to without them being logged into the system??

2: playlist (add songs from owned library to playlists, also check if borrowed and don't allow to play if so)

3: library sorting setting (changing profile setting) (Ben is in the process of geting this to work)

4: We need to move the functionality of borrowing a song from option 5 (send message) to option 3 (borrow a song)

5: need to impliment taking back a song that has been lent

6: library sorting (actually sorting the songs) (Ben is in the process of geting this to work)

7: song visability (profile option to allow songs to be friends only or public browsing)

8: being able to change the borrow length, and be either time in minutes or num plays (in profile seetings)

9: Library searching (we have by single friend working, but need to impliment by all friends and by public)


Issues recently fixed
=====================

1: users' friends lists are now synced, if one user has another user as a friend, but not vice versa,
they will both be added to each other's friends list.

2: Users were showing up on the logged in list more than once.

3: added check in User.java for empty friends list
