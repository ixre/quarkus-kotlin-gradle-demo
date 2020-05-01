package net.fze.mzl.board.util.jwt

import com.line.arch.commons.std.Types
import io.smallrye.jwt.build.Jwt
import org.eclipse.microprofile.jwt.Claims
import java.nio.charset.Charset
import java.security.KeyFactory
import java.security.PrivateKey
import java.security.spec.PKCS8EncodedKeySpec
import java.util.*


/**
 * Utilities for generating a JWT for testing
 */
object TokenUtils {
    /**
     * Utility method to generate a JWT string from a JSON resource file that is signed by the privateKey.pem
     * test resource key, possibly with invalid fields.
     *
     * @param keyId - key id
     * @param claims - used to return the exp, iat, auth_time claims
     * @return the JWT string
     * @throws Exception on parse failure
     */
    @Throws(Exception::class)
    fun generateTokenString(privateKeyPath:String?,keyId:String,claims: Map<String, Any>,
                            expiresSeconds:Int): String {
        // Use the test private key associated with the test public key for a valid signature
        val pk = readPrivateKey(privateKeyPath?:"/META-INF/private_key.pem")
        return generateTokenString(pk, keyId, claims, expiresSeconds)
    }

    @Throws(Exception::class)
    private fun generateTokenString(privateKey: PrivateKey, keyId: String,
                                    claims: Map<String, Any>, expiresSeconds:Int): String {
        val claimsBuilder = Jwt.claims(claims)
        val currentTimeInSecs = currentTimeInSecs().toLong()
        val exp = currentTimeInSecs + (if(expiresSeconds>0)expiresSeconds else 300 );
        claimsBuilder.issuedAt(currentTimeInSecs)
        claimsBuilder.claim(Claims.auth_time.name, currentTimeInSecs)
        claimsBuilder.expiresAt(exp)
        return claimsBuilder.jws().signatureKeyId(keyId).sign(privateKey)
    }

    /**
     * Read a PEM encoded private key from the classpath
     *
     * @param pemResName - key file resource name
     * @return PrivateKey
     * @throws Exception on decode failure
     */
    @Throws(Exception::class)
    fun readPrivateKey(pemResName: String): PrivateKey {
        TokenUtils::class.java.getResourceAsStream(pemResName).use { contentIS ->
            val tmp = ByteArray(4096)
            val length = contentIS.read(tmp)
            return decodePrivateKey(String(tmp, 0, length, Charset.forName("UTF-8")))
        }
    }

    /**
     * Decode a PEM encoded private key string to an RSA PrivateKey
     *
     * @param pemEncoded - PEM string for private key
     * @return PrivateKey
     * @throws Exception on decode failure
     */
    @Throws(Exception::class)
    private fun decodePrivateKey(pemEncoded: String): PrivateKey {
        val encodedBytes = toEncodedBytes(pemEncoded)
        val keySpec = PKCS8EncodedKeySpec(encodedBytes)
        val kf = KeyFactory.getInstance("RSA")
        return kf.generatePrivate(keySpec)
    }

    private fun toEncodedBytes(pemEncoded: String): ByteArray {
        val normalizedPem = removeBeginEnd(pemEncoded)
        return Base64.getMimeDecoder().decode(normalizedPem)
    }

    private fun removeBeginEnd(pem: String): String {
        var pem = pem
        pem = pem.replace("-----BEGIN (.*)-----".toRegex(), "")
        pem = pem.replace("-----END (.*)----".toRegex(), "")
        pem = pem.replace("\r\n".toRegex(), "")
        pem = pem.replace("\n".toRegex(), "")
        return pem.trim { it <= ' ' }
    }

    /**
     * @return the current time in seconds since epoch
     */
    private fun currentTimeInSecs(): Int {
        val currentTimeMS = System.currentTimeMillis()
        return (currentTimeMS / 1000).toInt()
    }
}