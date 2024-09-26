def iniBoard(n):
    key=['queen','row','col','nw','sw']
    for i in key:
         board[i]={}
    for j in range(n):
        board['queen'][j]=0
        board['row'][j]=0
        board['col'][j]=0
    for i in range(-(n-1),n):
        board['nw'][i]=0
    for i in range(2*n-1):
        board['sw'][i]=0

def free(i,j):
    if board['row'][i]==0 and board['col'][j]==0 and board['nw'][j-i]==0 and board['sw'][i+j]==0:
        return True
    return False

def addq(i,j):
    if free(i,j):
        print((i,j))
        board['queen'][i]=j
        board['row'][i]=1
        board['col'][j]=1
        board['nw'][j-i]=1
        board['sw'][j+i]=1
        
def undoq(i,j):
    board['queen'][i]=-1
    board['row'][i]=0
    board['col'][j]=0
    board['nw'][j-i]=0
    board['sw'][j+i]=0
    
def placeq(i):
    n=len(board['queen'].keys())
    for j in range(n):
        if free(i,j):
            addq(i,j)
        if i==n-1:
            return True
        extend_soln=placeq(i+1)
        if extend_soln:
            return True
        else:
            undoq(i,j)
    return False
            
def printq():
    for i in range(len(board['queen'].keys())):
        for j in range(len(board['queen'].keys())):
            if board['queen'][i]==j:
                print("Q",end=" ")
            else:
                print("X",end=" ")
        print()

board={}
n=int(input("Enter size of board: "))
iniBoard(n)
check=placeq(0)
if check:
    printq()
else:
    print("Not able to place all Queens")
