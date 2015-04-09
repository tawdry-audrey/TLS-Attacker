/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS.
 *
 * Copyright (C) 2015 Juraj Somorovsky
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.rub.nds.tlsattacker.tls.misc;

import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

/**
 * If you run on an Oracle Java platform, it is possible that strong algorithms
 * are not allowed. In this case, you have to install a so called Unlimited
 * Strength Jurisdiction Policy
 * 
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class UnlimitedStrengthTest {

    final Logger logger = LogManager.getLogger(UnlimitedStrengthTest.class);

    @Test
    public void testAES256() throws Exception {
	try {
	    Cipher encryptCipher = Cipher.getInstance("AES/CBC/NoPadding", new BouncyCastleProvider());
	    IvParameterSpec encryptIv = new IvParameterSpec(new byte[16]);
	    SecretKey encryptKey = new SecretKeySpec(new byte[32], "AES");
	    encryptCipher.init(Cipher.ENCRYPT_MODE, encryptKey, encryptIv);
	} catch (InvalidKeyException ex) {
	    logger.warn("AES256 is probably not supported, you have to install Java Cryptography "
		    + "Extension (JCE) Unlimited Strength Jurisdiction Policy Files.");
	}
    }
}