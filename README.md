# Mars Rover Application

### Requirements
The project is to create a program to control rovers on the surface of Mars. The surface is represented by a plateau, which will be a 4-sided grid in this context.

<br />

#### Key Features
- The user will be able to...
  - define the XY dimensions of a plateau
  - input instructions to move the rover
  - view the position of the rover


- The program will be able to...
  - validate user input
  - create a plateau from dimensions
  - place rover at position 0,0
  - parse instructions from user input

<br />

#### Assumptions & Approach
- If coordinates exceed the dimensions of the plateau, the rover will carry out the instructions as well as it can and return the remaining instructions.
- Basic flow pattern:
  - User is prompted to input dimensions for plateau
    - Program places rover in the corner of the plateau at (0,0)
    - User is prompted to give instructions to move the rover
    - Program returns new position of rover
    

    - *User is able to continue loop of new instructions or end program*

<br />

### Future Implementations
- Can this be visualised?
  - As a grid in the console or as a web application?


- Can multiple rovers be sent out?
  - How will they be controlled?
  - How will the user select which rover to control or view their positions?
  - How will instructions be validated to prevent rovers colliding with each other?