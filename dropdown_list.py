import tkinter
from tkinter import ttk

demo = ["王玉车", "王姐", "金史诗", "宋英杰", "林李致远", "曹尼玛", "操尼玛"]


def list_adjustment(event):
    global result
    global userinput
    if event.char != '' and event.char != '\b':
        userinput = text.get() + event.char
        result = [i for i in demo if userinput in i]
    elif event.char == '\b':
        userinput = text.get()[:-1]
        result = [i for i in demo if userinput in i]
    else:
        result = []
    comboxlist["values"] = result


def send_mohu():
    print(userinput)


def send_list():
    print(comboxlist.get())


win = tkinter.Tk()  # 构造窗体
win.title('请输入人员名字')
win.geometry("+600+200")
win.geometry('300x200')
#创建按钮以及组件
mohu_comand = tkinter.Button(win, text='发送输入字段', command=send_mohu).grid(row=2, column=1)
list_comand = tkinter.Button(win, text='发送选中字段', command=send_list).grid(row=4, column=1)
comvalue = tkinter.StringVar()  # 窗体自带的文本，新建一个值
comboxlist = ttk.Combobox(win, textvariable=comvalue)  # 初始化
comboxlist["values"] = demo
comboxlist.grid(row=3,column=1,pady = 10)
text = tkinter.Entry(win, borderwidth=1, width=20)
text.bind('<Key>', list_adjustment)
text.grid(row=1, column=1,padx = 70,pady = 15)

win.mainloop()  # 进入消息循环