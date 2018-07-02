package solace.guava

import com.google.common.reflect.TypeToken
import kotlin.reflect.KClass

inline val <reified T> Class<T>.typeToken: TypeToken<T> get() = TypeToken.of(this)
inline val <reified T : Any> KClass<T>.typeToken: TypeToken<T> get() = TypeToken.of(this.java)

inline fun <reified T> TypeToken(): TypeToken<T> = TypeToken.of(T::class.java)