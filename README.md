## Description

This project is made using JavaFX platform and CSS stylesheet. It can help to calculate the payment of the workers. It helped me to understand how inner dialog works simultaneously with the main pane.

<br/>

## Sequence diagram:

![](IMAGES/sequence.png)

<br/>

## Output

### Application opens

![](IMAGES/output0.png)

### When I hover over New Hire Booking button

![](IMAGES/output1.png)

### When I click on this button, a dialog opens where we have to choose the dates and fill in the cost/day

![](IMAGES/output2.png)

#### The date picker looks like

![](IMAGES/output11.png)

### Case 1: When I fill in the details correctly

![](IMAGES/output3.png)

#### I click on ok and the main window shows the total amount to be paid to the worker for the number of days one worked = end date-start date

![](IMAGES/output4.png)

### Case 2: I fill in the cost but leave out dates field like the following

![](IMAGES/output5.png)

#### I click on ok and the main window shows error message

![](IMAGES/output6.png)

### Case 3: I choose the dates but leave out cost field like the following

![](IMAGES/output7.png)

#### I click on ok and the main window shows error message

![](IMAGES/output8.png)

### Case 4: I choose the dates, fill in the cost field but the order of dates is incorrect, here the end date is before the start date like the following

![](IMAGES/output9.png)

#### I click on ok and the main window shows error message

![](IMAGES/output10.png)

### Case 5: I choose the dates, fill in the cost field but the cost is negative like the following

![](IMAGES/output12.png)

#### I click on ok and the main window shows error message

![](IMAGES/output13.png)

### Case 6: When I leave out everything

![](IMAGES/output2.png)

#### I click on ok and the main window shows error - the very first thing which is not correct in the datepicker dialog will throw the error, so here it will show incorrect dates error because that is not chosen, later it will got to cost if the user picks the correct date

![](IMAGES/output6.png)

## Case 7: I enter everything incorrectly like the following

![](IMAGES/output14.png)

#### I click on ok and the main window shows error - the very first thing which is not correct in the datepicker dialog will throw the error, so here it will show incorrect dates error because that is not chosen, later it will got to cost if the user picks the correct date

![](IMAGES/output6.png)




