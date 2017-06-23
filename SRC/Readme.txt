GameLauncher
    -Used for initialization routines

GameFrame
    -This is the frame of the window
    -This should also contain key listeners for keys such as esc
    -Lots to do
GraphicsPanel
*GraphicsPanel will load from a file (probably plain text) system (space) or planet (earth) information.
     That information will be planet/system background as well as any objects on the planet/system.
*GraphicsPanel will take the filepath for system data as a parameter.
*GraphicsPanel will return a string that is either a planet name, system name, or return to menu.
  Or an integer and we just index planets and systems.
    -This is where graphics will be drawn for the game
    -Lots more to do
PlayerCharacter
  -This class will be for 'people'
  -non-player-character should be subclass of this (for AI's)
PlayerShip
  -This class will be for space ships
  -Non-player-ship should be a subclass
Objects
  -For objects that the users can interact with but do not act on their own
