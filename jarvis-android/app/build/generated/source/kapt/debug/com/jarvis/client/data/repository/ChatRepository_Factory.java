package com.jarvis.client.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class ChatRepository_Factory implements Factory<ChatRepository> {
  private final Provider<OkHttpClient> clientProvider;

  public ChatRepository_Factory(Provider<OkHttpClient> clientProvider) {
    this.clientProvider = clientProvider;
  }

  @Override
  public ChatRepository get() {
    return newInstance(clientProvider.get());
  }

  public static ChatRepository_Factory create(Provider<OkHttpClient> clientProvider) {
    return new ChatRepository_Factory(clientProvider);
  }

  public static ChatRepository newInstance(OkHttpClient client) {
    return new ChatRepository(client);
  }
}
