package com.jarvis.client.data.repository;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import com.jarvis.client.data.model.Message;
import com.jarvis.client.data.model.MessageType;
import com.jarvis.client.data.model.MessageStatus;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/jarvis/client/data/repository/ChatRepository;", "", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "_messages", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/jarvis/client/data/model/Message;", "messages", "Lkotlinx/coroutines/flow/StateFlow;", "getMessages", "()Lkotlinx/coroutines/flow/StateFlow;", "webSocket", "Lokhttp3/WebSocket;", "connect", "", "sendMessage", "text", "", "app_debug"})
public final class ChatRepository {
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.Nullable()
    private okhttp3.WebSocket webSocket;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.jarvis.client.data.model.Message>> _messages = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.jarvis.client.data.model.Message>> messages = null;
    
    @javax.inject.Inject()
    public ChatRepository(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.jarvis.client.data.model.Message>> getMessages() {
        return null;
    }
    
    public final void connect() {
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
}