# DIP : Unwanted Object Removal

Many a times it happens that undesirable objects creep into our photographs. They may partially or completely overlap our main subject or just become an eye-sore in the frame..

![For example](https://github.com/Souruly/Java-Projects/blob/master/DIP%20-%20Object%20Removal%20with%20Mode/Images%20for%20Readme/20160617_190029.jpg?raw=true)
This photo would be better without the highlighted objects.

<br>
This code aims at addressing this issue..
<br><br>

## How it works : 
Consider these 4 sample images given to you each containing some kind of noise overlaping the true subject: <br>
![Sample Images](https://github.com/Souruly/Java-Projects/blob/master/DIP%20-%20Object%20Removal%20with%20Mode/Images%20for%20Readme/Untitled2.png?raw=true)
<br>
Red Part : Unwanted subject.<br>
Green Part : Target subject.

From these 4 faulty images, we aim to produce one noise free image containing only the true subject: <br>
![Target Image](https://github.com/Souruly/Java-Projects/blob/master/DIP%20-%20Object%20Removal%20with%20Mode/Images%20for%20Readme/Untitled3.png?raw=true)

On closer observation of the given sample set, we can infer that the unwanted subject occupies only finite amount(25x25 pixels) of space from the total real estate(image res. : 100x100 pixels) at a time. 

In the given sample set, consider **image 1**. The noise appears in the **top left corner**. But we can easily reconstruct the top left corner from the respective areas of the other three images. Similarly, **for every contrasting pixel in space that appears because of the undesirable object, there are 3 acceptable pixels corresponding to the same location(coordinates) of the image.**

But, as humans, we can easily recognize what belongs to the picture and what doesn't. For computers, a pixel, differently colored from it's neighbors might as well be a feature of the object! Unless a special thinking process isn't induced, as a raw input-output machine, computers are really dumb. But what the lack in thinking is made up for by performing harder calculations over largers sets of numbers.

We can provide it with a large number of images and it can easily figure out what's changing between frame to frame.
Then, we maintain a simple rule, 
>Look for the things that remain *unchanged* across **most** of the images.<br>

For this, we can use the [Mode](https://en.wikipedia.org/wiki/Mode_(statistics)) method in statistics..

Algorithm : <br>
**For every pixel location corresponding to each of the images, calculate the mode colour and set the corresponding pixel location of the output image to that colour.**

![Example 2](https://github.com/Souruly/Java-Projects/blob/master/DIP%20-%20Object%20Removal%20with%20Mode/Images%20for%20Readme/Untitled1.png?raw=true)
<br>
Here, the running man is an unwanted object which changes across the 5 images. On running the program with the 5 images as input, the target image should be generated.



## Using this code : 
The program uses 5* faulty images as input to produce one processed image as output.
It would try its best to remove the fault from the input images.

**Note : It can take less that 5 images as input, but internally it would copy the first image to make the total number of images to 5. However, this is not recommended.* 


1. Download and save the entire project folder.
2. The code is already compiled but it is recommended that you do it yourself. To do this, use command : 
<br>`javac ImageProcess.java`.<br>
This would generate the `ImageProcess.class` file.
3. Get the images you want to process in same folder as the `*.class` and `*.java` files. You can use your own images but try testing out sample images.
4. Now run the java program using the command line with arguements. For example <br>
`java ImageProcess img1.jpg img2.jpg img3.jpg img4.jpg img5.jpg` <br>
5. The execution may take some time depending on the processing power of the machine and the resolution of the images. Once completed, the output will be saved in the project folder.

**Note :**<br> In an ideal world(Sample Image Set 1) this would work perfectly. This is because the image is not subject to changing environmental conditions to a slightest degree. *That* what shouldn't change, *doesn't change at all*. 
But in the real world, the slightest camera shake, change in focus, exposure, etc. changes the value of a pixel. Blue can become Light Blue, Dark Blue, Sky Blue, Teal, Peackock Blue, anything... Therefore, we observe that for most pixels the 'mode' value has only one occurence which leads to the object not being removed completely.(examples can be found in Sample Set 2,3). Unless a more lineant/better approach is used in pixel sorting, this can and will happen.

## Update Log : 
**5th December 2017**<br>
![Thresholding](https://github.com/Souruly/Java-Projects/blob/master/DIP%20-%20Object%20Removal%20with%20Mode/Images%20for%20Readme/Compare.jpg?raw=true)
I kinda implemented the thresholding feature that I talked about in the 'Notes for the Future' part. So as expected, it works, but not as I wanted to..I think the problem is with the thresholding algorithm. I found that in a given lower and upper bound of numbers, you can limit the gamut by converting the int to an int typecasted float and back to int. <br>
For example : Consider a list

> 10 , 154 , 238 , 240 , 242

Now if we apply a threshold of ±5, the last three numbers are basically the same.
If we divide each number by 5 to convert it to float, we get

>2.0 , 30.8 , 47.6 , 48.0 , 48.4

Float typecasted as Int

>2 , 31 , 48 , 48 , 48 

Multiply by 5 to regain semi-original values

>10 , 155 , 240 , 240 , 240 

If you can find a better approach please make the pull request and make necessary updates to the code(near line 56).

## Notes for the Future : 
1. Better results could be achieved with a color threshold for processing pixels of real photographs.
2. Faster algorithms??
3. I've already seen what using "Average"(Mean) instead of Mode does. But it would be interesting to see what "Median" does.
