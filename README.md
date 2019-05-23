# thrift百科：

thrift是一个软件框架，用来进行可扩展且跨语言的服务的开发。它结合了功能强大的软件堆栈和代码生成引擎，
以构建在 C++, Java, Go,Python, PHP, Ruby, Erlang, Perl, Haskell, C#, Cocoa, JavaScript, Node.js, 
Smalltalk, and OCaml 这些编程语言间无缝结合的、高效的服务。

# RPC：

RPC（Remote Procedure Call Protocol）——远程过程调用协议，它是一种通过网络从远程计算机程序上请求服务，
而不需要了解底层网络技术的协议。RPC协议假定某些传输协议的存在，如TCP或UDP，为通信程序之间携带信息数据。
在OSI网络通信模型中，RPC跨越了传输层和应用层。RPC使得开发包括网络分布式多程序在内的应用程序更加容易。

# thrift types:

# 1.基本类型（括号内为对应的Java类型）：

    bool（boolean）: 布尔类型(TRUE or FALSE)
    byte（byte）: 8位带符号整数
    i16（short）: 16位带符号整数
    i32（int）: 32位带符号整数
    i64（long）: 64位带符号整数
    double（double）: 64位浮点数
    string（String）: 采用UTF-8编码的字符串

# 2.特殊类型（括号内为对应的Java类型）：

    binary（ByteBuffer）：未经过编码的字节流

# 3.Structs（结构）：

    struct定义了一个很普通的OOP对象，但是没有继承特性。
    
    struct UserProfile {
      1: i32 uid,
      2: string name,
      3: string blurb
    }
    
    如果变量有默认值，可以直接写在定义文件里:
    
    struct UserProfile {
      1: i32 uid = 1,
      2: string name = "User1",
      3: string blurb
    }

# 4.容器，除了上面提到的基本数据类型，Thrift还支持以下容器类型：

    list(java.util.ArrayList)：
    set(java.util.HashSet)：
    map（java.util.HashMap）：
    
    用法如下：
    
    struct Node {
      1: i32 id,
      2: string name,
      3: list<i32> subNodeList,
      4: map<i32,string> subNodeMap,
      5: set<i32> subNodeSet
    }
    
    包含定义的其他Object:
    
    struct SubNode {
      1: i32 uid,
      2: string name,
      3: i32 pid
    }
    
    struct Node {
      1: i32 uid,
      2: string name,
      3: list<subNode> subNodes
    }

# 5.Services服务，也就是对外展现的接口：

    service UserStorage {
      void store(1: UserProfile user),
      UserProfile retrieve(1: i32 uid)
    }

# 6.
