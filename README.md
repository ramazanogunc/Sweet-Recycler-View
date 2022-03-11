<p>
  <h1 align="center">
    Sweet Recycler View
  </h1>
</p>
<p align="justify">
    
  ![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white)
  ![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
  ![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84.svg?style=for-the-badge&logo=android-studio&logoColor=white)
  [![](https://jitpack.io/v/ramazanogunc/Sweet-Recycler-View.svg)](https://jitpack.io/#ramazanogunc/Sweet-Recycler-View)
  [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

SweetRecyclerView is a custom recyclerview library. SweetRecyclerView includes the list adapter itself, so <b>you don't have to write a listadapter.</b>
</p>

# Features 
- Easy to use ✅
- Support multi viewholder ✅
- Support onitemclicklistenner ✅
- Support list adapter ✅
- Support identifiable diff util callback ✅
- Support custom adapter ✅

# How to use
<b>Add jitpack repository in the project build.gradle</b>
```
allprojects {
 repositories {
   maven { url 'https://jitpack.io' }
  }
}
```
<b>Add module dependecy</b> 
```
implementation 'com.github.ramazanogunc:Sweet-Recycler-View:0.9.0'
```
<b>Add Sweet Recycler View in xml</b>

You can use normal recyclerview attirbute in this xml
``` xml
<com.ramo.sweetrecycler.SweetRecyclerView
    android:id="@+id/sweetRecycler"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```
<b>Use render function in kotlin code</b>

You can use multiple viewholder in this function. You can decide the viewholder from the data.
``` kotlin
sweetRecycler.render<MyModel> { viewGroup, position, data ->
    // you can use your viewholder with extended SweetViewHolder 
    // or
    // you can use directly SweetViewholder or VBSweetViewholder or DBSweetViewholder
    return@render SweetViewHolder<MyModel>(
          R.layout.item_user,
          viewGroup,
          onBindData = { view, position, data ->
              view.findViewById<AppCompatTextView>(R.id.txtUsername).text = data.title
          },
      )
}
```
## Viewholders
There are 3 viewholder class. You can use whatever you want.
- SweetViewHolder<T> : Work normal view inflate
- VBSweetViewHolder<VB : ViewBinding, T> : Work with viewbinding 
- DBSweetViewHolder<T> : Work with databinding 

You can use these classes directly or you can derive and use your own viewholder classes from them.
Below is an example of all uses
### SweetViewHolder<T>
SweetViewHolder works normal view. You can use findviewbyid in onBind function. You can use it like below 2 methods.
#### Usage 1 Example
``` kotlin
sweetRecycler.render<MyModel> { viewGroup, position, data ->
    return@render SweetViewHolder<MyModel>(
          R.layout.item_user,
          viewGroup,
          onBindData = { view, position, data ->
              view.findViewById<AppCompatTextView>(R.id.txtUsername).text = data.title
          },
      )
}
```
#### Usage 2 Example
Create your viewholder class with extended SweetViewHolder
``` kotlin
sweetRecycler.render<MyModel> { viewGroup, position, data ->
    return@render UserViewHolder(viewGroup)
}
```
UserViewHolder
``` kotlin
class UserViewHolder(
    viewGroup: ViewGroup
) : SweetViewHolder<MyModel>(
    R.layout.item_user,
    viewGroup
) {
    override fun bind(data: MyModel) {
        itemView.findViewById<AppCompatTextView>(R.id.txtUsername).text = data.title
        // other bind and onclick callbacks
    }
}
```
### VBSweetViewHolder<VB : ViewBinding, T>
VBSweetViewHolder works with viewbinding. You can use binding instance in onBind function. You can use it like below 2 methods.
#### Usage 1 Example
``` kotlin
sweetRecycler.render<MyModel> { viewGroup, position, data ->
    return@render VBSweetViewHolder<ItemProductBinding, MyModel>(
            ItemUserBinding::inflate,
            viewGroup,
            onBindData = { binding, position, data ->
                binding.txtUsername.text = data.title
            },
        )
}
```
#### Usage 2 Example
Create your viewholder class with extended VBSweetViewHolder
``` kotlin
sweetRecycler.render<MyModel> { viewGroup, position, data ->
    return@render UserViewHolder(viewGroup)
}
```
UserViewHolder
``` kotlin
class UserViewHolder(
    viewGroup: ViewGroup
) : VBSweetViewHolder<ItemUserBinding, MyModel>(
    ItemUserBinding::inflate,
    viewGroup
) {
    override fun bind(data: MyModel) {
        binding.txtUsername.text = data.title
        // other bind and onclick callbacks
    }
}
```
### DBSweetViewHolder<T>
DBSweetViewHolder works with databinding. You can use binding instance in onBind function. You can use it like below 2 methods.
#### Usage 1 Example
``` kotlin
sweetRecycler.render<MyModel> { viewGroup, position, data ->
    return@render DBSweetViewHolder<MyModel>(
            R.layout.item_user_data_binding,
            viewGroup,
            onBindData = { binding, position, data ->
                binding.setVariable(BR.data, data)
                binding.executePendingBindings()
            },
        )
}
```
#### Usage 2 Example
Create your viewholder class with extended DBSweetViewHolder
``` kotlin
sweetRecycler.render<MyModel> { viewGroup, position, data ->
    return@render UserViewHolder(viewGroup)
}
```
UserViewHolder
``` kotlin
class UserViewHolder(
    viewGroup: ViewGroup
) : DBSweetViewHolder<MyModel>(
    R.layout.item_user_data_binding,
    viewGroup
) {
    override fun bind(data: MyModel) {
        binding.setVariable(BR.data, data)
        binding.executePendingBindings()
        // other bind and onclick callbacks
    }
}
```
## Model
  For a standard diffutilcallback you don't need to add anything to the model. You can use your direct model.
  
  But if you want to use a diffutilcallback that works with id, all you have to do is to implemlentation the "Identifiable" interface in your model. Here is the exmaple model
  ``` kotlin
  data class MyModel(
    val title: String,
    val isUser: Boolean,
) : Identifiable {
    override val id: String
        get() = "here is your id"
}
  ``` 
# Advenced usage
  coming soon

# Architecture
  coming soon

# License
```
MIT License

Copyright (c) 2022 ramazanogunc

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
