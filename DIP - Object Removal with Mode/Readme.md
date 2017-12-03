# DIP : Unwanted Object Removal

Many a times it happens that undesirable objects creep into our photographs. They may partially or completely overlap our main subject or just become an eye-sore in the frame..

![For example](https://lh3.googleusercontent.com/ovlFcTMedNbDg4TN_ja3hECHbhnJGbIGQqi8GYL1y16kkIp1KyeOJ8WjDgt_NBeGE-tOnSIbc3Q76lWG5XqSw8nHG8gpJGqL4BpErEQyKiYCXKuN2OLMfsliFhqf28jhBQ0whYIwdvNpE-EHvRxNSPa7v3ptaecHftu0pSaBaqitUa38VFcvYhHxuHn9A6NxNEO5b6lS518i0uYpbcw6WEPhuw-lizz-uriiY4D48Cw_NicRItzmWftzUzMVbf8kNN7Uj9Kn69K4AdkqI1tx3fjWqYUvNeUL_zvGVdIkAPV69xy8GOLRAmtlQbhulU-qpoYjThKYVF0wys2q21up3J2ytKFEH-i4aeIWqz4txKmdowYHaLS2B_hz_XkDho_yIX814NYkt3Ss8cb-srRFWxhBBTIrPCX9b0h0EYDOzNr2Joj6XPGwUmwqP2f1LIPa9WHQSau-wWgGDg5TdqwtRZHmnOsDDPfqYNhLQaFww2yEKuxEtoON2R1paGyB69IOZOvZyhaOdx0P-bKKsI5jGjafZ9YJjGI_uuXpMAChoPnpoZc74_ckzZWoEOTfxvVgmMQhkEh5P1guZU5XonK0RR_w13Fk0WMIRC7JliCx9Q=w1046-h588-no)
This photo would be better without the highlighted objects.

<br>
This code aims at addressing this issue..
<br><br>

## How it works : 
Consider these 4 sample images given to you each containing some kind of noise overlaping the true subject: <br>
![Sample Images](https://lh3.googleusercontent.com/zbMqu5sKNk7xQqXc1eMw_7g6c_dBP3wrXXfZRrcSMs7jlnkw_YjJ2Da66PXp3jZAKz3DhcGUf_qi2sU7PUFFV73QgEI8U1Ef6iTn2u2X-9E0SLcqDhic4VZteCO16TakL8oXCIGvyLU5Irhzh5pO90nqKTfhdZYTvAqcJy31rx1aKi2fL5LcLulDSioMWaHaVndxDtnJPwgScJRBHdUq_cjaZ_rw2eGKatOW5_vdgNiPS4ThWoJNsxrH1aADzCWnW8xqe2pi4qpx2byJ6f_31Slk_1sAb5Dl567bxBixa3zPjmYtX6VQKgosv5OnO5IdoWBg8RDMOVBVfdqT7Du-v9Qqq7N5YMy2BrHo82QIUippkXusKuzjcbbY_kLdDB2ZTjvXiZk4QFVA7lVhheVOKsls10UQfFX4c5xM5-6dKslLAnRLx497Qkbj_Hawb7uNlWKwKiuqh5pt_s8Z6sAGkGwCf039CgUlezZmVqKqloJi9aWnzro7wSOvK1r2dZwcttfXeEtw1ji7ERuQ1qJbUzPkYblM11oInY2oydQr10aCNpI1HMwY5NyFHhrDGDvZhC21RVA_V2MmWevXtdpVAipiTyCVkhSjgN12Q6Y5wg=w400-h120-no)
<br>
Red Part : Unwanted subject.<br>
Green Part : Target subject.

From these 4 faulty images, we aim to produce one noise free image containing only the true subject: <br>
![Target Image](https://lh3.googleusercontent.com/2OdMgWVFtw-kcUDQfjJolr6ppSmgs0XKmxFTVMkrS71XY0EZi5z9OWGGhrIXKZLeZLUX0LKDNwQgs3bI_ShAK1F9Jvos_L5dq1KjFHLZTm7FLaAnrx6kYE8nVb8u-ja1D1Mh1Ht98qMLBBNxRCUAjQw0XX1gnG2hSUBzkNc_kIiYGsaLFlt5b8B_1NC-_Fq2EYKSbm-Zn7U_UhTzmRwWZtwGM00My5M9nd5bC4M4IunJFctwI0HejupRKbrxajjBkpCnZMoCd5q4cFkuz55gTLYyl_-iOTfzsxUiuSQL2CTLFC1rBeDTufuWsRy6-wVifBGWnHgIJV3ko9iYbjmZkgWJhrQKzZIsSBWujgLrDmuWbuQ2eLCLXLMFOz71MNw8sYYnjOkWH3Ti88wzL5iY_5DmrfX4K7kCrpyFt-kUZ_5RupTczh6oeeJcVWD-yjYIsaDQ6hS93uNxsVgWRCL9S0ibKF-FL0wUYcxcU_IwAGqqTTY1g-6ezMVsZ0G0xP6eUjgcFwazCQUbFWIxr0aPtiyeFa6M0_bWdwS2Bp6oVzoK1wWgK-2Hb3ZuqNSv1RCtcK43A1Oftac39W7ka7qZ-XHb_QjM-CXLgOGaGE2Sng=s100-no)

On closer observation of the given sample set, we can infer that the unwanted subject occupies only finite amount(25x25 pixels) of space from the total real estate(image res. : 100x100 pixels) at a time. 

In the given sample set, consider **image 1**. The noise appears in the **top left corner**. But we can easily reconstruct the top left corner from the respective areas of the other three images. Similarly, **for every contrasting pixel in space that appears because of the undesirable object, there are 3 acceptable pixels corresponding to the same location(coordinates) of the image.**

But, as humans, we can easily recognize what belongs to the picture and what doesn't. For computers, a pixel, differently colored from it's neighbors might as well be a feature of the object! Unless a special thinking process isn't induced, as a raw input-output machine, computers are really dumb. But what the lack in thinking is made up for by performing harder calculations over largers sets of numbers.

We can provide it with a large number of images and it can easily figure out what's changing between frame to frame.
Then, we maintain a simple rule, 'Look for the things that remain *unchanged* across **most** of the images."<br>

For this, we can use the [Mode](https://en.wikipedia.org/wiki/Mode_(statistics)) method in statistics..

Algorithm : <br>
**For every pixel location corresponding to each of the images, calculate the mode colour and set the corresponding pixel location of the output image to that coloour.**

![Example 2](https://lh3.googleusercontent.com/QW-VWHrB_KoeyhFm41RF6nzPPDdOvF8rdb_ZrxLBFgCoqSv603fcCN4K6S4ak_3vfhjNen07MLoAsup10rRUdLH76pAJML_G2BuwO-d2njbHXZLLbtgEwaC6SA8nXvA1xsoVdj0PYo8xFwWtfEKicawOZu9pkTWWNwEnnBkxHtprQlBNinrN88wh87QSY_Mno7KCIwdzzbEbiyKfJ1wWx6aohMj1KczXaRahNOd6nE05HFbrHtabf1Pbx29xRd1KQndVvbf98BOShJQoaqvFfHH6DLqUyyHXZfkdePGMbmjwDXhTDizfzteKRwPQP2pQWo9Z8gIVG5M_tfEXgccTZ8Ne0FdeT81RxvZYEHGMsj0nDbSqhqmQ-t15BNWiVuGG7UlFcUrkM5q5ZkqE9BxMvH4_Ib2FP9Isi2glBIJfeL0r_gDTFl-GkKZpmkj50NJsU2P0xZB5HT6vr0OgKO454OaXY9LPLNNG3INE5qUs9aVcry6UxLIyKEJFjA2FyqPcWPCjJnZJ8eu4UDNbwEUcbkXLyJAxUdNUfrxJ1hghUfuVuD-PRhE1_GNA1xwrDrWb6AGc17P9uF4wFazJyngwTWbLCkLThNHCzOp_vjrGMA=w499-h597-no)
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


## Notes for the future : 
1. Better results could be achieved with a color threshold for processing pixels of real photographs.
2. Faster algorithms??
