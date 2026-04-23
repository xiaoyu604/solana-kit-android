package io.horizontalsystems.solanakit.models

import com.solana.networking.Network
import com.solana.networking.RPCEndpoint
import java.net.URL

sealed class RpcSource(var name: String, var endpoint: RPCEndpoint, val syncInterval: Long) {
    val url: URL = endpoint.url

    object Serum: RpcSource("Serum Project API", RPCEndpoint.mainnetBetaSerum, 30)
    object TritonOne: RpcSource("TritonOne API", RPCEndpoint.mainnetBetaSolana, 30)
    object Alchemy: RpcSource("Alchemy API", RPCEndpoint.custom(URL("https://solana-mainnet.g.alchemy.com/v2/Hy5Pc7K9_36cmVlzm_yZDUrZqTYD3xMM"), URL("https://solana-mainnet.g.alchemy.com/v2/Hy5Pc7K9_36cmVlzm_yZDUrZqTYD3xMM"), Network.mainnetBeta), 30)
    class Custom(name: String, httpURL: URL, websocketURL: URL, syncInterval: Long): RpcSource(name, RPCEndpoint.custom(httpURL, websocketURL, Network.mainnetBeta), syncInterval)
}
